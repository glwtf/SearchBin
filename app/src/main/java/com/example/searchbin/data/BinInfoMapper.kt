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
        bank = binInfoItem.bank
    )

    fun mapDbModelToEntity(BinInfoDbModel: BinInfoDbModel) = BinInfo(
        bin = BinInfoDbModel.bin,
        number = BinInfoDbModel.number,
        scheme = BinInfoDbModel.scheme,
        type = BinInfoDbModel.type,
        brand = BinInfoDbModel.brand,
        prepaid = BinInfoDbModel.prepaid,
        country = BinInfoDbModel.country,
        bank = BinInfoDbModel.bank
    )

    fun mapListDbModelToListEntity(list : List<BinInfoDbModel>) = list.map {
        mapDbModelToEntity(it)
    }

}