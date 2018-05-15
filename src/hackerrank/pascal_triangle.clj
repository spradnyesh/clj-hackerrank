(ns hackerrank.pascal-triangle)

;; https://www.hackerrank.com/challenges/pascals-triangle/problem

(defn h-pascal-triangle [n]
  (condp = n
    0 [1]
    1 [1 1]
    (concat [1]
            (mapv #(apply + %)
                     (partition 2 1 (h-pascal-triangle (dec n))))
            [1])))

(defn pascal-triangle [n]
  (dotimes [i n]
    (apply println (h-pascal-triangle i))))

;; (pascal-triangle (Integer/parseInt (read-line)))
