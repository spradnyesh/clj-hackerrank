(ns hackerrank.polygon-perimeter)

;; https://www.hackerrank.com/challenges/lambda-march-compute-the-perimeter-of-a-polygon/problem

(defn distance [[[x1 y1] [x2 y2]]]
  (Math/sqrt (+ (Math/pow (- x2 x1) 2)
                (Math/pow (- y2 y1) 2))))

(defn polygon-perimiter [arr]
  (reduce +
          (map distance
               (conj (partition 2 1 arr)
                     [(last arr) (first arr)]))))

(def t (Integer/parseInt (read-line)))
(dotimes [_ t]
  (->> t
       range
       (mapv (fn [_]
               (mapv #(Integer/parseInt %)
                     (clojure.string/split (read-line) #" "))))
       polygon-perimiter
       println))
