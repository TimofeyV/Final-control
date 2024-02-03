<!-- 1 -->
cat > Pets
Собака Кошка Хомяк (ctrl + D)
cat > PackAnimals
Лошадь Верблюд Осёл (ctrl + D)
cat Pets PackAnimals > mrg
cat mrg
mv mrg HumanFriends
<!-- 2 -->
mkdir test
mv HumanFriends test
<!-- 3 -->
sudo apt-get update
sudo apt install mysql-server
<!-- 4 -->
wget https://dev.mysql.com/get/mysql-apt-config_0.8.26-1_all.deb
sudo dpkg --install mysql-apt-config_0.8.26-1_all.deb
sudo dpkg -r mysql-apt-config