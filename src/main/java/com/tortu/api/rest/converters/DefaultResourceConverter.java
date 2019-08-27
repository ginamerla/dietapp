package com.tortu.api.rest.converters;

/**
 * Interface para mapear de un modelo <M> a un recurso rest <R>.
 * @param <M> Modelo que queremos convertir.
 * @param <R> Nuevo objeto basado en la info del modelo proporcionado.
 * @author visilva
 */
public interface DefaultResourceConverter<M, R> {

    R  convert(M model);
}
