(ns hackerrank.sum-of-odd-elements)

;; https://www.hackerrank.com/challenges/fp-sum-of-odd-elements/problem

(fn sum-of-odd-elements [lst]
  (reduce + (filter odd? lst)))
