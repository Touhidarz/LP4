def fabonacci():
    n = int(input("Enter length :"))
    Arr = []
    # Arr[0] = 0
    # Arr[1] = 1
    Arr = [0,1]
    for i in range(2,n):
        x = Arr[i-2] + Arr[i-1]
        Arr.append(x)
        
    
    for i in range(n):
        print(Arr[i])
    

def main():
    
    fabonacci()
main()