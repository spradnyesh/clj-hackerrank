(ns hackerrank.climbing-leaderboard)

(def scores [100 100 50 40 40 20 10])
(def alice [5 25 50 120])

;; terminated due to timeout on tests-6/7/8/9
;; why: w/o `into #{}`, the list is too long to peruse
(defn climbingLeaderboard [scores alice]
  (let [find-rank (fn [rank arr curr a]
                    (cond
                      (= curr (first arr)) (recur rank (rest arr) curr a)
                      (empty? arr) rank
                      (>= a (first arr)) rank
                      :else (recur (inc rank) (rest arr) (first arr) a)))]
    (mapv #(find-rank 1 scores -1 %) alice)))

;; terminated due to timeout on tests-6/7/9
;; why: `into #{}` is taking time
(defn climbingLeaderboard-2 [scores alice]
  (let [rev-scores (reverse scores)
        cnt (inc (count (into #{} scores)))
        find-rank (fn [rank arr curr a]
                    (cond
                      (= curr (first arr)) (recur rank (rest arr) curr a)
                      (empty? arr) rank
                      (< a (first arr)) rank
                      :else (recur (inc rank) (rest arr) (first arr) a)))]
    (mapv (fn [a]
            (->> a
                 (find-rank 0 rev-scores -1)
                 (- cnt)))
          alice)))

;; terminated due to timeout on tests-6/7/9
;; why: `sort` is taking time
(defn climbingLeaderboard-1 [scores alice]
  (let [unique-scores (->> scores
                           (into (sorted-set))
                           vec)
        cnt (inc (count unique-scores))
        find-rank (fn [rank arr a]
                    (cond
                      (empty? arr) rank
                      (< a (first arr)) rank
                      :else (recur (inc rank) (rest arr) a)))]
    (mapv (fn [a]
            (->> a
                 (find-rank 0 unique-scores)
                 (- cnt)))
          alice)))

;; terminated due to timeout on tests-6/7/9
;; why: `sort` and `indexOf` is taking time
(defn climbingLeaderboard-0 [scores alice]
  (mapv (fn [a]
          (->> a
               (conj scores)
               (into #{})
               sort
               reverse
               (#(.indexOf % a))
               inc))
        alice))

;; (def fptr (get (System/getenv) "OUTPUT_PATH"))

;; (def scores-count (Integer/parseInt (clojure.string/trim (read-line))))

;; (def scores (vec (map #(Integer/parseInt %) (clojure.string/split (read-line) #" "))))

;; (def alice-count (Integer/parseInt (clojure.string/trim (read-line))))

;; (def alice (vec (map #(Integer/parseInt %) (clojure.string/split (read-line) #" "))))

;; (def result (climbingLeaderboard scores alice))

;; (spit fptr (clojure.string/join "\n" result) :append true)
;; (spit fptr "\n" :append true)
