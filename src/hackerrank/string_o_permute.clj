(ns hackerrank.string-o-permute)

;; https://www.hackerrank.com/challenges/string-o-permute/problem

(defn string-o-permute [s]
  (clojure.string/join #""
                       (mapcat (fn [[a b]] [b a])
                               (partition 2 s))))

(let [n (Integer/parseInt (read-line))]
  (dotimes [_ n]
    (println (string-o-permute (read-line)))))
