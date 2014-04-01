{:user {:dependencies [[leiningen #=(leiningen.core.main/leiningen-version)]
                       [im.chit/vinyasa "0.1.9"]
                       [spyscope "0.1.4"]]
        :plugins [[lein-kibit "0.0.8"]
                  [jonase/eastwood "0.0.2"]]
        :injections [(require 'spyscope.core)
                     (require '[vinyasa.inject :as inj])
                     (inj/inject 'clojure.core
                                 '[[vinyasa.inject inject]
                                   [vinyasa.pull pull]
                                   [vinyasa.lein lein]
                                   [vinyasa.reimport reimport]
                                   [clojure.repl doc source]
                                   [clojure.pprint pprint pp print-table]])]
        :repl-options {:init (do
                               (require '[clojure.pprint :refer :all]
                                        '[clojure.reflect :refer :all])
                               ; http://clojuredocs.org/clojure_core/clojure.pprint/print-table
                               ; example: (inspect clojure.lang.BigInt)
                               (defn inspect [o]
                                 (let [r (:members (reflect o))] ;
                                   (print-table [:name :type :flags]
                                                (sort-by :name r)))))}}}