### subarray
```
Arrays.copyOfRange(res,0,count);
```
### string to char array
```
String s1="hello";  
char[] ch=s1.toCharArray();  
```

### deep copy an array
```
int[] src  = new int[]{1,2,3,4,5};
int[] dest = new int[5];
System.arraycopy( src, 0, dest, 0, src.length );
```