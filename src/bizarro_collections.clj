(ns bizarro-collections
  (:refer-clojure :exclude [hash-map])
  (:import
    [bizarro_collections
     BizarroHashMap]))

(defn ^BizarroHashMap hash-map
  "Returns a version of java.util.HashMap which uses Clojure's equality semantics."
  ([]
     (BizarroHashMap.))
  ([a b]
     (doto (BizarroHashMap.)
       (.put a b)))
  ([a b c d]
     (doto (BizarroHashMap.)
       (.put a b)
       (.put c d)))
  ([a b c d & kvs]
     (let [^BizarroHashMap
           m (doto (BizarroHashMap.)
               (.put a b)
               (.put c d))]
       (loop [s kvs]
         (when-not (empty? s)
           (let [k (first s)
                 s' (rest s)]
             (if (empty? s')
               (throw (IllegalArgumentException. "odd number of arguments to hash-map"))
               (do
                 (.put m k (first s'))
                 (recur (rest s')))))))
       m)))
