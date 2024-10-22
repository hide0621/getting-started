package org.acme

import jakarta.inject.Inject
import jakarta.ws.rs.Path

import com.google.cloud.storage.Blob;
import com.google.cloud.storage.Bucket;
import com.google.cloud.storage.Storage;
import jakarta.ws.rs.GET
import jakarta.ws.rs.Produces
import jakarta.ws.rs.core.MediaType


@Path("/storage")
class StorageResource {

    @Inject
    lateinit var storage: Storage

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    fun storage(): String {

        // ここではGoogle Cloud Storageのバケット名を入れる
        val bucket: Bucket = storage.get("bucketName")

        // ここでは取得したいファイルのパスを入れる
        val blob: Blob = bucket.get("filePath")
        return blob.getContent().toString()
    }

}