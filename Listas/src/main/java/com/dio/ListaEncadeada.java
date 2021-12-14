package com.dio;

public class ListaEncadeada<T> {

    No<T> referenciaEntrada;

    public ListaEncadeada() {
        this.referenciaEntrada = null;
    }

    public T get(int indice){
        return getNo(indice).getConteudo();
    }

    private No<T> getNo(int indice){

        validaIndice(indice);

        No<T> noAuxiliar = referenciaEntrada;
        No<T> noRetorno = null;

        for (int i = 0; i < this.size()-1; i++){
            noRetorno = noAuxiliar;
            noAuxiliar = noAuxiliar.getProximoNo();
        }
        return noRetorno;
    }

    public T remove(int index){
        No<T> noPivo = this.getNo(index);
        if (index == 0){
            referenciaEntrada = noPivo.getProximoNo();
            return noPivo.getConteudo();
        }

        No<T> noAnterior = getNo(index-1);
        noAnterior.setProximoNo(noPivo.getProximoNo());
        return noPivo.getConteudo();
    }

    public void add(T conteudo){
        No<T> novoNo = new No<>(conteudo);
        if (this.isEmpty()){
            referenciaEntrada = novoNo;
            return;
        }
        No<T> noAuxiliar = referenciaEntrada;
        for (int i = 0; i < this.size()-1; i++){
            noAuxiliar = noAuxiliar.getProximoNo();
        }
        noAuxiliar.setProximoNo(novoNo);

    }

    public int size() {
        int tam = 0;
        No referenciaAux = referenciaEntrada;
        while (true) {
            if (referenciaAux != null) {
                tam++;
                if (referenciaAux.getProximoNo() != null) {
                    referenciaAux = referenciaAux.getProximoNo();
                } else {
                    break;
                }
            } else {
                break;
            }
        }
        return tam;
    }

    public boolean isEmpty() {
        return this.referenciaEntrada == null;
    }

    public void validaIndice(int indice){
        if (indice >= size()){
            int ultimo = size()-1;
            throw new IndexOutOfBoundsException("Não existe conteudo no indice " + indice + "desta lista." + "Essa lista so vai ate o indice" + ultimo);
        }
    }
}
