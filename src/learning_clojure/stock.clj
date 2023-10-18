(ns learning-clojure.stock)

; hash map
(def stock {"Bag" 10, "Shirt" 5})                           ; { Bag 10, Shirt 5 }

(println (count stock))                                     ; 2
(println (keys stock))                                      ; ( Bag Shirt )
(println (vals stock))                                      ; ( 10 5 )


(def stock {:bag 10 :shirt 5})                              ; using keywords
(println (assoc stock :chair 3))
(println (update stock :bag inc))                           ; Bag 11
(println (update stock :bag #(- % 3)))                      ; Bag 7
(println (dissoc stock :bag))                               ; Removing bag


(def order {:bag   {:quantity 2, :price 80},
            :shirt {:quantity 3, :price 40}})

(println (order :bag))
(println (get order :bag {}))                               ; get with default value
(println (:bag order {}))                                   ; same as get above
(println (:quantity (:bag order)))                          ; 2
(println (update-in order [:bag :quantity] inc))            ; 3

; Threading first, using collections at the start
(println (-> order
             :bag
             :quantity))

(defn priceByProduct [[index value]]                        ; map destructuring
  (* (:quantity value) (:price value)))

(println (map priceByProduct order))
(println (reduce + (map priceByProduct order)))             ; order total price

; thread last, using collections at the final
(defn total [order]
  (->> order
       (map priceByProduct)
       (reduce +)))

(println "Total:" (total order))


(def order {:bag   {:quantity 2, :price 80},
            :shirt {:quantity 3, :price 40},
            :keychain { :quantity 1, :price 0 }})

(defn free?
  [item]
  (<= (get item :price 0) 0))

(println (filter (fn [[_ value]] (free? value)) order))