(ns hackerrank.update-list)

;; https://www.hackerrank.com/challenges/fp-update-list/problem

(fn update-list [lst]
  (mapv (fn [x] (if (>= x 0) x (- x))) lst))
