package com;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

// 将一个字符串按照zip方式压缩和解压缩
public class ZipUtil {

  // 压缩

  public static String compress(String str) throws IOException {
    if (str == null || str.length() == 0) {
      return str;
    }
    ByteArrayOutputStream out = new ByteArrayOutputStream();
    GZIPOutputStream gzip = new GZIPOutputStream(out);
    gzip.write(str.getBytes());
    gzip.close();
    return out.toString("GBK");
  }

  // 解压缩
  public static String uncompress(String str) throws IOException {
    if (str == null || str.length() == 0) {
      return str;
    }
    ByteArrayOutputStream out = new ByteArrayOutputStream();
    ByteArrayInputStream in = new ByteArrayInputStream(str
        .getBytes("GBK"));
    GZIPInputStream gunzip = new GZIPInputStream(in);
    byte[] buffer = new byte[256];
    int n;
    while ((n = gunzip.read(buffer)) >= 0) {
      out.write(buffer, 0, n);
    }
    // toString()使用平台默认编码，也可以显式的指定如toString("GBK")
    return out.toString();
  }

  // 测试方法
  public static void main(String[] args) throws IOException {
    System.out.println(ZipUtil.uncompress(ZipUtil.compress("VTJGc2RHVmtYMThJSTBObUw3M2kvanV2ZCtMZUdqK2ZvMUFiNTBtek1YczIxQ044MnNGZ0JXTzZSK0xSTFpWUwpMYnNZZk85RXNaRW1hZy9qb0U4ZHh1NWZSZHcwWU1UVw==")));
    System.out.println(ZipUtil.compress("VTJGc2RHVmtYMThJSTBObUw3M2kvanV2ZCtMZUdqK2ZvMUFiNTBtek1YczIxQ044MnNGZ0JXTzZSK0xSTFpWUwpMYnNZZk85RXNaRW1hZy9qb0U4ZHh1NWZSZHcwWU1UVw=="));
  }

}