main
	ldi r1,0
	ldi r2,0
	ldi r3,vet1
	ldw r4,vetsz1

while
	ldb r5,r3

	ldi r6,33
	slt r6,r5,r6
	bnz r6,if
	
	ldi r6,126
	slt r6,r6,r5	
	bnz r6,if
	
else
	bnz r7,while2
if
	slt r6,r4,r1
	bnz r6,end
	add r3,1
	add r1,1
	bnz r7,while	

while2
	ldb r5,r3

	ldi r6,32
	slt r6,r6,r5
	bez r6,else2

	ldi r6,127
	slt r6,r5,r6
	bez r6,else2

	bnz r6,if2

else2
	add r2,1
	bnz r7,while
if2
	slt r6,r4,r1
	add r2,r2,r6
	bnz r6,end

	add r1,1
	add r3,1
	bnz r7,while2


end
	stw r2,0xf002
	hcf

vet1	"Macacos me mordam"
vet2	"O rato roeu a roupa do rei de roma"
vetsz1	16
vetsz2	33