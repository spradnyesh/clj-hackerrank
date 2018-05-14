(ns polygon-area)

;; https://www.hackerrank.com/challenges/lambda-march-compute-the-area-of-a-polygon/problem
;; https://en.wikipedia.org/wiki/Shoelace_formula#More_complex_example

(defn polygon-area [arr]
  (let [f (fn [a?]
            (reduce +
                    (map (fn [[[x1 y1] [x2 y2]]]
                           (if a?
                             (* x1 y2)
                             (* y1 x2)))
                         (conj (vec (partition 2 1 arr))
                               [(last arr) (first arr)]))))
        a (f true)
        b (f false)]
    (/ (Math/abs (- a b)) 2)))

(def t (Integer/parseInt (read-line)))
(dotimes [_ t]
  (->> t
       range
       (mapv (fn [_]
               (mapv #(Integer/parseInt %)
                     (clojure.string/split (read-line) #" "))))
       polygon-area
       float
       println))
