(ns hackerrank.gcd)

;; https://www.hackerrank.com/challenges/functional-programming-warmups-in-recursion---gcd/problem

(fn gcd [x y]
  (cond (= x y) x
        (> x y) (recur (- x y) y)
        :else (recur (- y x) x)))
