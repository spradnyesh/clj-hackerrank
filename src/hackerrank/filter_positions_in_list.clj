(ns hackerrank.filter-positions-in-list)

;; https://www.hackerrank.com/challenges/fp-filter-positions-in-a-list/problem

(fn filter-positions-in-list [lst]
  (remove nil? (map-indexed (fn [idx itm] (when (odd? idx) itm)) lst)))
