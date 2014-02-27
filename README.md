![](doc/bizarro.png)

Clojure and Java maps don't only differ in terms of mutability, they also have different equality semantics:

```clj
> (assoc {} 1 2, 1N 3)
{1 3}
> (doto (java.util.HashMap.) (.put 1 2) (.put 1N 3))
{1 2, 1N 3}
```

This library provides a mutable hash-map that behaves like a normal `java.util.HashMap`, but has Clojure's equality semantics:

```clj
> (doto (bizarro-collections/hash-map) (.put 1 2) (.put 1N 3))
{1 3}
```

### usage

Add this to your `project.clj`:

```clj
[bizarro-collections "0.1.0"]
```

### license

Copyright © 2014 Zach Tellman

Distributed under the GPL v2