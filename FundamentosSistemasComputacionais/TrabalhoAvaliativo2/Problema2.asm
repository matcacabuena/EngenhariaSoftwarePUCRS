main
	ldi	r1,4
	ldi r2,8 
	ldi	r3,0
	ldi	r4,vet1
	
	add	r4,r4,r1
	add	r4,r4,r1
	
rep
	slt r5,r1,r2
	bnz	r5,if
	
	sub	r5,r1,r2
	bez	r5,if
	bnz	r5,end
	
if
	ldw	r6,r4
	
	add	r4,1
	add	r4,1

	add	r3,r3,r6

	add	r1,1
	bnz	r7,rep

end
	stw	r3,0xf002
	hcf


vet1	5 2 -2 -7 3 14 10 -3 9 -6 4 1
vet2	2 34 12 -17 22 38 -15 7 10 41