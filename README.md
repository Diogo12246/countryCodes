# INSTRUCTIONS

Inside the .rar (TechTask found in this repo) you shall find the jar with the input.txt and countryCodes.txt

countryCodes is hardcoded in the jar to search for its specific name "countryCodes.txt"

the input.txt is not, meaning, any txt provided will be read as long as you pass in the java args a .txt extension.

Program execution sample

```java
Java -jar CountryCodes.jar input.txt
```

# Difficulties

I had a bad time figuring out the part of the assignement where it said to make "00" 
a valid number.

The problem was not in the "00" or "00 ". The problem was in me not
knowing to which country I would map the 00 prefix.

I did a quick research and it is an international prefix, lots of places use it. So if the "input.txt" contains a 00 valid long number, probably will make it valid but it won't show because I have not mappedit to any country.

# All source code can be found in the git repo

https://github.com/Diogo12246/countryCodes
