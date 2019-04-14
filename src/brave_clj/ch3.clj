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


;;(use 'brave-clj.ch3 :reload-all)
(println "Successfully re-loaded all the forms !!")