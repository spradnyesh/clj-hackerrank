(ns hackerrank.string-reductions)

;; https://www.hackerrank.com/challenges/string-reductions/problem

(defn string-reductions [s]
  (let [f (fn [pre suf]
            (cond (empty? suf)
                  pre
                  ((into #{} pre) (first suf))
                  (recur pre (rest suf))
                  :else
                  (recur (conj pre (first suf)) (rest suf))))]
    (clojure.string/join #"" (f [] s))))

;; (println (string-reductions (read-line)))
