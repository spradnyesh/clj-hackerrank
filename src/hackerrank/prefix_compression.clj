(ns hackerrank.prefix-compression)

;; https://www.hackerrank.com/challenges/prefix-compression/problem

(defn prefix-compression [s1 s2]
  (let [f (fn [acc s1 s2]
            (cond (or (empty? s1) (empty? s2))
                  acc
                  (= (first s1) (first s2))
                  (recur (conj acc (first s1)) (rest s1) (rest s2))
                  :else
                  acc))
        rslt (f [] s1 s2)
        cnt (count rslt)
        cnt1 (- (count s1) cnt)
        cnt2 (- (count s2) cnt)
        join #(clojure.string/join #"" %)]
    (println cnt (join rslt))
    (println cnt1 (join (drop cnt s1)))
    (println cnt2 (join (drop cnt s2)))))

;; (prefix-compression (read-line) (read-line))
