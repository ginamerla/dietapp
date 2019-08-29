package com.tortu.api.rest.mappers;

/**
 * Interface para mapear de un modelo <M> a un recurso rest <R>.
 * @param <M> Modelo que queremos convertir.
 * @param <R> Nuevo objeto basado en la info del modelo proporcionado.
 * @author visilva
 */
public interface DefaultResourceMapper<M, R> {

    R mapper(M model);
}
