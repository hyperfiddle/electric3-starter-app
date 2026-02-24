(ns user) ; Under :dev alias, automatically load 'dev so the REPL is ready to go with zero interaction

(print "[user] loading dev... ") (flush)
(require 'dev) ; jetty 10+ – the default
#_(require '[dev-jetty9 :as dev]) ; require :jetty9 alias
(println "Ready.")

(comment
  (require '[clojure.repl.deps :refer [add-libs]])
  (add-libs '{com.hyperfiddle/hyperfiddle-agent {:local/root "../hyperfiddle-agent"}})
  (require '[hyperfiddle.navigator-agent :as agent] '[hyperfiddle.hfql2 :refer [hfql]])
  (def sitemap {`all-ns (hfql {(all-ns) {* [ns-name ns-publics]}})})
  (agent/connect! "wss://index.clojure.net/agent" sitemap))
