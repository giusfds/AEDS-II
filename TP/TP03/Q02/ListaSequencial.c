#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <stdbool.h>

#define MAX_TAM 404

int tamanho = 0;


typedef struct{
    int dia, mes, ano;
} LocalDate;



typedef struct{
    char id[50], name[50], alternate_names[200], house[50], ancestry[50], species[50], patronus[50], actorName[50], alternate_actors[200],
        eyeColour[50], gender[50], hairColour[50];
    int yearOfBirth;
    bool hogwartsStaff, hogwartsStudent, alive, wizard;
    LocalDate dateOfBirth;
} Personagem;

Personagem p[MAX_TAM];

void initPersonagem(Personagem *p)
{
    strcpy(p->id, "");
    strcpy(p->name, "");
    strcpy(p->alternate_names, "");
    strcpy(p->house, "");
    strcpy(p->ancestry, "");
    strcpy(p->species, "");
    strcpy(p->patronus, "");
    p->hogwartsStaff = false;
    p->hogwartsStudent = false;
    strcpy(p->actorName, "");
    p->alive = false;
    strcpy(p->alternate_actors, "");
    p->dateOfBirth.dia = -1;
    p->dateOfBirth.mes = -1;
    p->dateOfBirth.ano = -1;
    p->yearOfBirth = -1;
    strcpy(p->eyeColour, "");
    strcpy(p->gender, "");
    strcpy(p->hairColour, "");
    p->wizard = false;
}

void clonePersonagem(Personagem *destino, Personagem *origem)
{
    strncpy(destino->id, origem->id, strlen(destino->id));
    strncpy(destino->name, origem->name, strlen(destino->name));
    strncpy(destino->alternate_names, origem->alternate_names, strlen(destino->alternate_names));
    strncpy(destino->house, origem->house, strlen(destino->house));
    strncpy(destino->ancestry, origem->ancestry, strlen(destino->ancestry));
    strncpy(destino->species, origem->species, strlen(destino->species));
    strncpy(destino->patronus, origem->patronus, strlen(destino->patronus));
    destino->hogwartsStaff = origem->hogwartsStaff;
    destino->hogwartsStudent = origem->hogwartsStudent;
    strncpy(destino->actorName, origem->actorName, strlen(destino->actorName));
    destino->alive = origem->alive;
    strncpy(destino->alternate_actors, origem->alternate_actors, strlen(destino->alternate_actors));
    destino->dateOfBirth = origem->dateOfBirth;
    destino->yearOfBirth = origem->yearOfBirth;
    strncpy(destino->eyeColour, origem->eyeColour, strlen(destino->eyeColour));
    strncpy(destino->gender, origem->gender, strlen(destino->gender));
    strncpy(destino->hairColour, origem->hairColour, strlen(destino->hairColour));
    destino->wizard = origem->wizard;
}


LocalDate convertData(char data[])
{
    LocalDate localDate;
    sscanf(data, "%d-%02d-%04d", &localDate.dia, &localDate.mes, &localDate.ano);
    return localDate;
}


void setPersonagem(Personagem *p, char *line){
    char str[300], date[11], year[5];
    strcpy(str, line);
    int x = 0, y = 0;

    while (str[x] != ';'){p->id[y] = str[x];x++;y++;}p->id[y] = '\0';x++;y = 0;
    while (str[x] != ';'){p->name[y] = str[x];x++;y++;}p->name[y] = '\0';x++;y = 0;
    while (str[x] != ';'){if (str[x] != '[' && str[x] != ']' && str[x] != 39){p->alternate_names[y] = str[x];y++;}x++;}p->alternate_names[y] = '\0';x++;y = 0;
    while (str[x] != ';'){p->house[y] = str[x];x++;y++;}p->house[y] = '\0';x++;y = 0;
    while (str[x] != ';'){p->ancestry[y] = str[x];x++;y++;}p->ancestry[y] = '\0';x++;y = 0;
    while (str[x] != ';'){p->species[y] = str[x];x++;y++;}p->species[y] = '\0';x++;y = 0;
    while (str[x] != ';'){p->patronus[y] = str[x];x++;y++;}p->patronus[y] = '\0';x++;y = 0;
    while (str[x] != ';'){if (str[x] == 'V'){p->hogwartsStaff = true;x += 10;}else{p->hogwartsStaff = false;x += 5;}}x++;y = 0;
    while (str[x] != ';'){if (str[x] == 'V'){p->hogwartsStudent = true;x += 10;}else{p->hogwartsStudent = false;x += 5;}}x++;y = 0;
    while (str[x] != ';'){p->actorName[y] = str[x];x++;y++;}p->actorName[y] = '\0';x++;y = 0;
    while (str[x] != ';'){if (str[x] == 'V'){p->alive = true;x += 10;}else{p->alive = false;x += 5;}}x++;y = 0;
    while (str[x] != ';'){p->alternate_actors[y] = str[x];x++;y++;}p->alternate_actors[y] = '\0';x++;y = 0;
    while (str[x] != ';'){date[y] = str[x];x++;y++;}LocalDate data = convertData(date);p->dateOfBirth = data;x++;y = 0;
    while (str[x] != ';'){year[y] = str[x];x++;y++;}p->yearOfBirth = atoi(year);x++;y = 0;
    while (str[x] != ';'){p->eyeColour[y] = str[x];x++;y++;}p->eyeColour[y] = '\0';x++;y = 0;
    while (str[x] != ';'){p->gender[y] = str[x];x++;y++;}p->gender[y] = '\0';x++;y = 0;
    while (str[x] != ';'){p->hairColour[y] = str[x];x++;y++;}p->hairColour[y] = '\0';x++;y = 0;if (str[x] == 'V'){p->wizard = true;x += 10;}else{p->wizard = false;x += 5;}
}


void arrayOfPersonagens(Personagem p[], int key){
    char path[100];
    if (key == 1){
        strcpy(path, "/tmp/characters.csv");
    }else{
        strcpy(path, "seu path do arquivo csv");
    }
    FILE *file = fopen(path, "r");
    if (file == NULL){
        perror("Erro ao abrir o arquivo");
        return;
    }
    bool header = true;
    char line[300];
    int i = 0;
    while (fgets(line, sizeof(line), file)){
        if (header){
            header = false;
        }else{
            initPersonagem(&p[i]);
            setPersonagem(&p[i], line);
            i++;
        }
    }
    fclose(file);
}

void toString(Personagem *p, int id){
    printf("[%d ## %s ## %s ## {%s} ## %s ## %s ## %s ## %s ## %s ## %s ## %s ## %s ## %02d-%02d-%d ## %d ## %s ## %s ## %s ## %s]\n", id, p->id, p->name, p->alternate_names, p->house,
            p->ancestry, p->species, p->patronus, p->hogwartsStaff ? "true" : "false", p->hogwartsStudent ? "true" : "false", p->actorName, p->alive ? "true" : "false",
            p->dateOfBirth.dia, p->dateOfBirth.mes, p->dateOfBirth.ano, p->yearOfBirth, p->eyeColour, p->gender, p->hairColour, p->wizard ? "true" : "false");
}


void mostrar(){
    for (int i = 0; i < tamanho; i++){
        toString(&p[i], i);
    }
}


void inserirInicio(Personagem novo){
    if (tamanho >= MAX_TAM){
        printf("Array CHEIO!");
        exit(1);
    }
    for (int i = tamanho; i > 0; i--){
        p[i] = p[i - 1];
    }
    p[0] = novo;
    tamanho++;
}

void inserirFim(Personagem novo){
    if (tamanho >= MAX_TAM){
        printf("Array CHEIO!");
        exit(1);
    }
    p[tamanho] = novo;
    tamanho++;
}

void inserir(Personagem novo, int pos){
    if (tamanho >= MAX_TAM){
        printf("Array CHEIO!");
        exit(1);
    }
    for (int i = tamanho; i > pos; i--){
        p[i] = p[i - 1];
    }
    p[pos] = novo;
    tamanho++;
}

Personagem removerInicio(){
    if (tamanho == 0){
        printf("LISTA VAZIA!");
        Personagem vazio;
        strcpy(vazio.id, "");
        return vazio;
    }
    Personagem removido = p[0];
    tamanho--;
    for (int i = 0; i < tamanho; i++){
        p[i] = p[i + 1];
    }
    return removido;
}

Personagem removerFim(){
    if (tamanho == 0){
        printf("LISTA VAZIA!");
        Personagem vazio;
        strcpy(vazio.id, "");
        return vazio;
    }
    return p[--tamanho];
}

Personagem remover(int pos){
    if (tamanho == 0 || pos < 0 || pos >= tamanho){
        printf("Erro ao remover!");
        exit(1);
    }
    Personagem removido = p[pos];
    tamanho--;
    for (int i = pos; i < tamanho; i++){
        p[i] = p[i + 1];
    }
    return removido;
}


void makeArray(Personagem array[]){
    char strid[50];
    scanf("%s", strid);
    while (strcmp(strid, "FIM") != 0){
        for (int i = 0; i < MAX_TAM; i++){
            if (strcmp(array[i].id, strid) == 0){
                inserirFim(array[i]);
                i = MAX_TAM;
            }
        }
        scanf("%s", strid);
    }
}


Personagem findID(Personagem array[], char *id){
    Personagem personagem;
    if(id[strlen(id)+2]=='\n'){
        id[strlen(id)+2] = '\0';
    }
    for (int i = 0; i < MAX_TAM; i++){
        if(strcmp(array[i].id, id) == 0){
            personagem = array[i];
            i = MAX_TAM;
        }
    }
    return personagem;
}


void metodos(Personagem array[], int qtd) {
    char input[100];
    for (int i = 0; i < qtd; i++) {
        scanf(" %[^\n]", input);
        input[strcspn(input, "\n")] = '\0';
        Personagem novo;
        if (strncmp(input, "II ", 3) == 0) {
            char id[100];
            sscanf(input + 3, "%s", id);
            novo = findID(array, id);
            inserirInicio(novo);
        }
        else if (strncmp(input, "IF ", 3) == 0) {
            char id[100];
            sscanf(input + 3, "%s", id);
            novo = findID(array, id);
            inserirFim(novo);
        }
        else if (strncmp(input, "I* ", 3) == 0) {
            int pos;
            char id[100];
            sscanf(input + 3, "%d %s", &pos, id);
            novo = findID(array, id);
            inserir(novo, pos);
        }
        else if (strncmp(input, "RI", 2) == 0) {
            novo = removerInicio();
            printf("(R) %s\n", novo.name);
        }
        else if (strncmp(input, "RF", 2) == 0) {
            novo = removerFim();
            printf("(R) %s\n", novo.name);
        }
        else if (strncmp(input, "R* ", 3) == 0) {
            int pos;
            sscanf(input + 3, "%d", &pos);
            novo = remover(pos);
            printf("(R) %s\n", novo.name);
        }
        else {}
    }
    mostrar();
}
int main() {
    Personagem array[MAX_TAM];
    arrayOfPersonagens(array, 1); 
    makeArray(array);
    int x = 0;
    scanf(" %i", &x);
    metodos(array, x);
    return 0;
}
