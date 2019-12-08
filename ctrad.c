#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <string.h>

int main(int ac, char **av)
{
    char str[500];
    char stre[500];
    char tot[1000];
    
    if (ac != 5) {
        write(2, "Usage: ", 7);
        write(2, av[0], strlen(av[0]));
        write(2, " host port team number_of_clients\n", 34);
       return (84);
    }
    if (av[1][0] == '\0' || av[2][0] == '\0' || av[3][0] == '\0' || av[4][0] == '\0') {
        write(2, "Usage: ", 7);
        write(2, av[0], strlen(av[0]));
        write(2, " host port team number_of_clients\n", 34);
        return (84);
    }
    sprintf(str, "%s", "/usr/bin/java mainclass");
    sprintf(stre, " %s %s %s %s", av[1], av[2], av[3], av[4]);
    sprintf(tot, "%s%s", str, stre);
    //printf("str = %s\n", tot);
    system(tot);
    return (0);
}
