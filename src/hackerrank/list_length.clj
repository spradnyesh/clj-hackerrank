(ns hackerrank.list-length)

;; https://www.hackerrank.com/challenges/fp-list-length/problem

(fn list-length [lst]
  (let [f (fn [acc cnt]
            (if (empty? acc) cnt (recur (rest acc) (inc cnt))))]
    (f lst 0)))
