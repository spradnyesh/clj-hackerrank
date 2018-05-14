(ns hackerrank.list-replication)

;; https://www.hackerrank.com/challenges/fp-list-replication/problem

(fn list-replication [n lst]
  (dorun (map #(dotimes [_ n] (println %)) lst)))

;; (def n (Integer/parseInt (read-line)))
;; (println n)
;; (def lst (mapv (fn [x] (Integer/parseInt (read-line))) (range n)))
;; (println lst)
;; (list-replication n lst)
