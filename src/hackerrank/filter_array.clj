(ns hackerrank.filter-array)

;; https://www.hackerrank.com/challenges/fp-filter-array/problem

(fn [delim lst]
  (filter #(< % delim) lst))
