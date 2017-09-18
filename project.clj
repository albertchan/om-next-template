(defproject om-next-template "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url  "http://www.eclipse.org/legal/epl-v10.html"}

  :dependencies [[org.clojure/clojure "1.8.0"]
                 [org.clojure/clojurescript "1.9.908"]
                 [org.omcljs/om "1.0.0-beta1"]
                 [com.stuartsierra/component "0.3.2"]]

  :plugins [[lein-cljsbuild "1.1.7"]]

  :source-paths ["src/clj" "src/cljs"]

  :test-paths ["test/clj"]

  :clean-targets ^{:protect false} [:target-path :compile-path "resources/public/js" "resources/public/out"]

  :uberjar-name "om-next-template.jar"

  :cljsbuild
  {:builds
   [{:id           "advanced"
     :source-paths ["src/cljs" "dev"]
     :compiler     {:output-to     "resources/public/js/app.js"
                    :output-dir    "resources/public/out"
                    :optimizations :advanced
                    :pretty-print  false}}]}

  ;; When running figwheel from nREPL, figwheel will read this configuration
  ;; stanza, but it will read it without passing through leiningen's profile
  ;; merging. So don't put a :figwheel section under the :dev profile, it will
  ;; not be picked up, instead configure figwheel here on the top level.

  :figwheel
  {;; :server-port 3449 ;; default
   ;; :server-ip "127.0.0.1" ;; default
   :css-dirs ["resources/public/css"]} ;; watch and update CSS

  :profiles
  {:dev
   {:dependencies [[figwheel "0.5.13"]
                   [figwheel-sidecar "0.5.13"]
                   [com.cemerick/piggieback "0.2.2"]
                   [org.clojure/tools.nrepl "0.2.12"]]
    :plugins      [[lein-figwheel "0.5.13"]]
    :source-paths ["dev"]
    :repl-options {:nrepl-middleware [cemerick.piggieback/wrap-cljs-repl]}}

   :uberjar
   {:source-paths ^:replace ["src/clj"]
    :prep-tasks   ["compile"
                   ["cljsbuild" "once" "min"]]
    :omit-source  true
    :aot          :all}})
