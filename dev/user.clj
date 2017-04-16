(ns user
  (:require [pprint-warning.server]
            [ring.middleware.reload :refer [wrap-reload]]
            [figwheel-sidecar.repl-api :as figwheel]
            [leiningen.core.main :as lein]))

;; Let Clojure warn you when it needs to reflect on types, or when it does math
;; on unboxed numbers. In both cases you should add type annotations to prevent
;; degraded performance.
(set! *warn-on-reflection* true)
(set! *unchecked-math* :warn-on-boxed)
(def http-handler
  (wrap-reload #'pprint-warning.server/http-handler))

(defn start-scss []
  (future
    (println "Starting scss.")
    (lein/-main ["sass" "auto"])))

(defn run []
  ;; Enabling this next line will produce warnings like:
  ;; WARNING: Use of undeclared Var cljs.pprint/*out* at line 3146 resources\public\js\compiled\out\cljs\pprint.cljs
  (start-scss)
  (figwheel/start-figwheel!))

(def browser-repl figwheel/cljs-repl)
