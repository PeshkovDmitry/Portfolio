package ru.gb.homework20240416.service;

import ru.gb.homework20240416.domain.Characters;
import ru.gb.homework20240416.domain.Result;

public interface ServiceApi {

    Characters getCharactersList(int page);

    Result getCharacterInfo(int id);

}
