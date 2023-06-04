@echo off
color 0a
"C:\Program Files\7-Zip\7z" a -sdel tmp.null build
del tmp.null
cd dist
advzip.exe -z -3 GreentextPlus.jar