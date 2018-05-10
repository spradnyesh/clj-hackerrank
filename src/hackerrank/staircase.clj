(ns hackerrank.staircase)

;; https://www.hackerrank.com/challenges/staircase/problem

(defn staircase [n]
  (dorun (map (fn [i]
                (let [f (fn [acc cntr]
                          (cond

                            (< cntr (- n i 1))
                            (recur (conj acc " ") (inc cntr))

                            (< cntr n)
                            (recur (conj acc "#") (inc cntr))

                            :else acc))]
                  (println (clojure.string/join "" (f [] 0)))))
              (range n))))

;; (def n (Integer/parseInt (clojure.string/trim (read-line))))
;; (staircase n)
