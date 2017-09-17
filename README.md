# om-next-template

Om Next template with figwheel and SCSS hot-reload.

## Usage

You must have `sassc` installed in order to have your SCSS stylesheets
compile and hot-reload.

To run from the command line:

```
cd om-next-template
lein run -m clojure.main script/figwheel.clj
```

or

```
cd om-next-template
rlwrap lein run -m clojure.main --init script/figwheel.clj -r
```

If you're using Emacs, just start up the repl with `cider-jack-in` and evaluate
the contents of `script/figwheel.clj` in the repl:

```
user> (load-file "script/figwheel.clj")
```

Then point your browser to [http://localhost:3449](http://localhost:3449).

## SASS compilation

To compile your SCSS stylesheets to CSS, issue

```
lein sassc once
```

To automatically recompile when files change, you can use

```
lein auto sassc
```

## References
- [Figwheel](https://github.com/bhauman/lein-figwheel)
- [Scripting with Component](https://github.com/bhauman/lein-figwheel#scripting-with-component)
- [SASS watcher](https://github.com/bhauman/lein-figwheel/wiki/SASS-watcher)

## License

Copyright © 2017 Albert Chan

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
