(ns hackerrank.functions-or-not)

;; https://www.hackerrank.com/challenges/functions-or-not/problem
(defn is-fn? [arr]
  (= (count arr) (count (into #{} (mapv first arr)))))

(def t (Integer/parseInt (read-line)))
(dotimes [_ t]
  (let [n (Integer/parseInt (read-line))]
    (if (is-fn? (mapv (fn [_] (clojure.string/split (read-line) #" "))
                     (range n)))
        (println "YES")
        (println "NO"))))
