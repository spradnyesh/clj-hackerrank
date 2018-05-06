(ns hackerrank.climbing-leaderboard)

(def scores [100 100 50 40 40 20 10])
(def alice [5 25 50 120])

(defn wrong [scores alice]
  (let [ecila (reverse alice)
        state (atom {:rslts [[0 ecila]]
                     :cur-rank 1
                     :cur-score (first scores)})
        _ (dorun (map (fn [s]
                        (when (not= s (:cur-score @state))
                          (swap! state assoc
                                 :cur-rank (inc (:cur-rank @state))
                                 :cur-score s))
                        (let [partial-ecila (second (last (:rslts @state)))]
                          (dorun (map-indexed (fn [j a]
                                                (when (>= a s)
                                                  (swap! state update-in
                                                         [:rslts] conj [(:cur-score @state)
                                                                        (drop (inc j) partial-ecila)])))
                                              partial-ecila))))
                      scores))
        rslt (reverse (mapv first (drop 1 (:rslts @state))))]
    (if (empty? (second (last (:rslts @state))))
      rslt
      (reduce (fn [arr _]
                (conj arr (+ (first rslt)
                             (count (second (last (:rslts @state))))
                             1)))
              rslt
              (second (last (:rslts @state)))))))

;; terminated due to timeout on tests-6/7/8/9
(defn climbingLeaderboard-6 [scores alice]
  (let [ecila (reverse alice)
        rslts (atom [[0 ecila]])
        _ (dorun (map-indexed (fn [i s]
                                (let [partial-ecila (second (last @rslts))]
                                  (dorun (map-indexed (fn [j a]
                                                        (when (>= a s)
                                                          (swap! rslts conj [(inc i) (drop (inc j) partial-ecila)])))
                                                      partial-ecila))))
                              (reverse (into (sorted-set) scores))))
        rslt (reverse (mapv first (drop 1 @rslts)))]
    (if (empty? (second (last @rslts)))
      rslt
      (reduce (fn [arr _]
                (conj arr (+ (first rslt)
                             (count (second (last @rslts)))
                             1)))
              rslt
              (second (last @rslts))))))

;; terminated due to timeout on tests-6/7/8/9
(defn climbingLeaderboard-5 [scores alice]
  (let [rslts (atom (list [1 scores]))
        find-rank (fn [rank arr cur-score a]
                    (cond
                      (= cur-score (first arr)) (recur rank (rest arr) cur-score a)
                      (empty? arr) [rank arr]
                      (>= a (first arr)) [rank arr]
                      :else (recur (inc rank) (rest arr) (first arr) a)))]
    (mapv (fn [a]
            (let [tmp (first @rslts)
                  cur-rank (first tmp)
                  cur-arr (second tmp)
                  rslt (find-rank cur-rank
                                  cur-arr
                                  -1
                                  a)]
              (swap! rslts conj rslt)))
          (reverse alice))
    (mapv first (drop-last 1 @rslts))))

;; terminated due to timeout on tests-6/7/8/9
;; why: `into (sorted-set)`
(defn climbingLeaderboard-4 [scores alice]
  (let [rslts (atom (list 1))
        unique-scores (reverse (into (sorted-set) scores))
        find-rank (fn [rank arr curr a]
                    (cond
                      (= curr (first arr)) (recur rank (rest arr) curr a)
                      (empty? arr) rank
                      (>= a (first arr)) rank
                      :else (recur (inc rank) (rest arr) (first arr) a)))]
    (mapv (fn [a]
            (let [cur-rank (dec (first @rslts))]
              (swap! rslts
                     conj (inc (find-rank cur-rank
                                          (drop cur-rank unique-scores)
                                          -1
                                          a)))))
          (reverse alice))
    (drop-last 1 @rslts)))

;; terminated due to timeout on tests-6/7/8/9
;; why: w/o `into #{}`, the list is too long to peruse
(defn climbingLeaderboard-3 [scores alice]
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
