package com.example.searchbin.data

import com.example.searchbin.domain.BinInfo

class BinInfoMapper {

    fun mapEntityToDbModel(binInfoItem: BinInfo) = BinInfoDbModel(
        bin = binInfoItem.bin,
        number = binInfoItem.number,
        scheme = binInfoItem.scheme,
        type = binInfoItem.type,
        brand = binInfoItem.brand,
        prepaid = binInfoItem.prepaid,
        country = binInfoItem.country,
        bank = binInfoItem.bank,
        time = binInfoItem.time
    )

    fun mapDbModelToEntity(binInfoDbModel: BinInfoDbModel) = BinInfo(
        bin = binInfoDbModel.bin,
        number = binInfoDbModel.number,
        scheme = binInfoDbModel.scheme,
        type = binInfoDbModel.type,
        brand = binInfoDbModel.brand,
        prepaid = binInfoDbModel.prepaid,
        country = binInfoDbModel.country,
        bank = binInfoDbModel.bank,
        time = binInfoDbModel.time
    )

    fun mapListDbModelToListEntity(list : List<BinInfoDbModel>) = list.map {
        mapDbModelToEntity(it)
    }

}