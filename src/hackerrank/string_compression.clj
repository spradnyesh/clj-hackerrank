(ns hackerrank.string-compression)

(defn string-compression [s]
  (let [f (fn [arr acc prev cnt]
            (cond (empty? arr) (conj acc cnt)
                  (= (first arr) prev) (recur (rest arr) acc prev (inc cnt))
                  :else (recur (rest arr) (conj acc cnt (first arr)) (first arr) 1)))]
    (clojure.string/join #""
                         (remove #(= 1 %)
                                 (f (rest s) [(first s)] (first s) 1)))))

(println (string-compression (read-line)))
