package tn.starter.mongoShared.mapper;

import java.util.List;

public interface GenericMapper<T,D> {
    D toEntity(T source);
    T toDto(D source);
    List<T> toListDto(List<D> source);
}