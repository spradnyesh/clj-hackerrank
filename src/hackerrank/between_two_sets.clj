(ns hackerrank.between-two-sets)

;; https://www.hackerrank.com/challenges/between-two-sets/problem

(defn getTotalX [arr1 arr2]
  (let [left (filter (fn [x] (every? zero? (mapv #(mod x %) arr1)))
                     (range (apply max arr1)
                            (inc (apply min arr2))))
        right (filter (fn [x] (every? zero? (mapv #(mod % x) arr2)))
                      left)]
    #_(count (clojure.set/intersection (into #{} left)
                                       (into #{} right)))
    (count (for [l left
                 r right
                 :when (= l r)]
             l))))
