(defproject mywebapp "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :dependencies [[org.clojure/clojure "1.4.0"]
                 [compojure "1.1.1"]
                 [hiccup "1.0.1"]
                 [org.clojure/tools.nrepl "0.2.0-beta10"]
                 [com.cemerick/drawbridge "0.0.6"]]
  :plugins [[lein-ring "0.7.3"]]
  :ring {:handler mywebapp.routes/app}
  :profiles
  {:dev {:dependencies [[ring-mock "0.1.3"]]}})
