(ns brave-clj.ch3)

;; Clojure forms
;; ===================================================================

;; !! Impotant thing to know that, everything in clojure is 'finction' !!

;; A clojure form is somthing that evaluats to itself, example numeric 1 is evaluated to 1 similarly string "binay" is evaluated to binay
;; 1 to 2
;; "Binay" to binay
;; ["a" "vector"] to vector data straucture

;; clojure used prefix notations. the great thing of prefix notation is it can take infinite arguments.
(+ 1 2 3)
;; The interesting thing to notic is that , in case of infix we have to repate the operator multiple times.
;; 1 + 2 + 3 ; (+) 3 times where in clojure it's only one time

(def my-full-name 
	(str "Binay" " " "Mishra"))

(println "My full name is " my-full-name)


;; Clojure Control Flow
;; ===================================================================

;; (if boolean-form
;; 	then-form
;;		optional-else-form)

;; Clojure functions always returns a value. the simplest value is nil which equvalent to null
(if true
	(println "TRUE")) ;; no else branch

(if false
	(println "TRUE")
		(println "FALSE")) ;; "FALSE is else branch"


(if true
	"By Zeus's hammer!"
	"By Aquaman's trident!")

(if false
	"By Zeus's hammer!"
	"By Aquaman's trident!")


;;do 
;; The do operator lets you wrap up multiple forms in parentheses and runeach of them.

(if true
	(do (println "Success!")
		"By Zeus's hammer!")
	(do (println "Failure!")
	"By Aquaman's trident!"))

;; when
;; The when operator is like a combination of if and do

(when true
	(println "Success!")
	"abra cadabra")


(nil? 1) 
;; false, because 1 evaluates to 1 which not nil

(nil? nil)
;; true, because nil is nil

(if "Binay Mishra"
	"My name is Binay Mishra")
; => "My name is Binay Mishra"
; any value in clojure is evaluates to itself value and if successfully evaluated, than it is true

(if nil
	("This part will not be returned because nil is false")
	"nil is false")
; => "nil is false"

;; or returns either the first truthy value or the last value
(or false nil :large_I_mean_venti :why_cant_I_just_say_large)
; large_I_mean_venti value got returned because it is the first truthly value encounted in the list. After false and nil

(or 
	(= 0 1)
	(= "yes" "no"))

; false
; (= 0 1) evaluates to false , (= "yes" "no") evaluates to false; 
; (or false false) the false will be returned because it is the last value

(or nil)
; nil
; not other truthy value found, hence nil just one value is the last value in secquence returned.

;; and returns the first falsey value or, if no values are falsey, the last truthy value
(and :free_wifi :hot_coffe)
; :hot_coffe

; :free_wifi and :hot_coffe is truthy values, so according to and it returned the last truthy value,
; because there is no falsely value in the secquence

 (and :feeling_super_cool nil false)
 ; nil
 ; Here the nil is return that is the first falsey value encounted. so no need to evaluate any further.


;; Binding value with def keyword. In other word declaring like variable with default values
(def failed-protagonist-names
	["Larry Potter" "Doreen the Explorer" "The Incredible Bulk"])


(defn error-message
	[severity]
		(str "OH GOD! IT'S A DISASTER! WE'RE "
			(if (= severity :mild)
				"MILDLY INCONVENIENCED!"
				"DOOOOOOOMED!")))


;; Data Structure
;; ===============================

;; Numbres

; 93  Long
(type 93)
;=> clojure.lang.Long
; 1.2 Double
(type 1.2)
;=> clojure.lang.Double
; 1/5 Ratio
(type 1/5)
;=> clojure.lang.Ratio

(def b-name 
	(str "Binay" " " "Mishra"))


;; Maps

{} ; empty map litrarls

{:first-name "Binay" 
 :last-name "Mishra"}

 (def plus-var 
 	{"plus-str" +})
 ;; this will create a map with key "plus-str" and value is finction / operator +
 ;; plus-var becomes map var
 (plus-var "plus-str")
 ; #object[clojure.core$_PLUS_ 0x6158e336 "clojure.core$_PLUS_@6158e336"]
 (type 
 	(plus-var "plus-str"))
;=> clojure.core$_PLUS_

;; Maps can be nested too

{:full-name {:first-name "Binay" :last-name "Mishra"}}

;; Map function

(hash-map :a 1 :b 2)
;=> (hash-map :a 1 :b 2)

(hash-map :a 0 :b {:c "Hey! there"})
;=>{:b {:c "Hey! there"}, :a 0}

({:b {:c "Hey! there"}, :a 0} :b)
;=> {:c "Hey! there"}

(get {:a 0 :b 1} :c)
;=> nil
;; not value corrosponding to :d

(get {:a 0 :b 1} :c "unicorns?")
;=> "unicorns?"
;; Default value


(get-in {:a 0 :b {:c "Hey! there"}} [:b :c])
;=> "Hey! there"
;; Order of the key matters in the vactor
(get-in {:a 0 :b {:c "Hey! there"}} [:c :b])
;=> nil
;; first , ({:a 0 :b {:c "Hey! there"}} :c) evaluated to nil

;; A map itself can become a function, same as a Keyword itself can become function
({:first-name "Binay" :last-name "Mishra"}  
	:first-name)
;=> "Binay"

(:first-name 
	{:first-name "Binay" :last-name "Mishra"})
;=> "Binay"

(get {:a 1 :b 2 :c 3} :a)
;=> 1
;; (get ) function is also used to get value from the map

;; Keywords
;; ============
;; Keywords are evaluated to itself. mostly used as key in the map, it brhaves like function too
:a
;=> :a
:rumplestiltsken
;=> :rumplestiltsken
:34
;=> :34
:_?
;=> _?

;; Vectors
;;=============

;; Basically Vectors are like array and can be heterogeneous

[1 2 3 4 5]

(get [1 2 3] 1)
;=> 2

[{:first-name "Binay"} "is" 34 "years" "old"]
(get [{:first-name "Binay"} "is" 34 "years" "old"] 0)
;=> {:first-name "Binay"}

;; Also have function. Not only Literal

(vector {:first-name "Binay"} "is" 34 "years" "old")
;=> [{:first-name "Binay"} "is" 34 "years" "old"]

;; Conjoin is to add more element into a vector
(conj [] 1 2 3)
;=> [1 2 3] its adds at the end of the vector, just like array.

(type (conj [] 1 2 3))
;=> clojure.lang.PersistentVector
;; It means every conjoin a new immutable copy of vector will be ctrated lazily. But is memort efficient not entire vector will be cteared.

(conj (vector 1 2) 3)
;=> [1 2 3]  same thing as above



;; Lists / Lazy Sequences
;; ====================

'() ;; Empty
;; the syntax starts with single ' (quote) because, the Paranthias should not be evaluated 
;; the clojue syntex is to evaluate forms between Paranthias.

(type '(1))
;=> clojure.lang.PersistentList

'(1 2 3)
;=> (1 2 3)
(list 1 2 3)
;=> (1 2 3)

(list 1 "two" {3 4})
;=> (1 "two" {3 4})

(conj '(1 2 3) 4)
;=> (4 1 2 3)
;; this add element at the begining of the list


;; Sets
;; ================
;; Holds only unique values
#{1 2 3 "set" :set}
(type #{1 2 3 "set" :set})
;:=> clojure.lang.PersistentHashSet

(hash-set 1 1 2 2)
;=> #{1 2}

(conj #{:a :b} :b)
;=> #{:a :b}

(contains? #{:a :b} :a)
;=> true

(contains? #{:a :b} 3)
;=> false

(get #{:a :b} :a)
;=> :a


(get #{:a :b} "Binay")
;=> nil

;;(use 'brave-clj.ch3 :reload-all)
(println "Successfully re-loaded all the forms !!")