(ns hackerrank.string-mingling)

;; https://www.hackerrank.com/challenges/string-mingling/problem

(defn string-mingling [p q]
  (let [join (fn [x] (clojure.string/join #"" x))]
    (join (mapcat #(join (vector % %2)) p q))))

;; zipmap changed the order
(defn string-mingling-0 [p q]
  (clojure.string/join #""
                       (mapcat #(clojure.string/join #"" %)
                               (zipmap p q))))

;; (println (string-mingling (read-line) (read-line)))
