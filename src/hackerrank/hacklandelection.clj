(ns hackerrank.hacklandelection)

;; https://github.com/spdeepak/hackerrank/tree/master/src/main/java/com/deepaksp/hackerrank/interview/hacklandelection

(def votes ["Alex", "Michael", "Harry", "Dave", "Michael", "Victor", "Harry", "Alex", "Mary", "Mary"])

(defn electionWinner [votes]
  (->> votes
       frequencies
       (sort-by (juxt second first))
       last
       first))
