#include<iostream>
#include<string>
#include <jni.h>

using namespace std;


string stringParse(JNIEnv *env, jstring jStr) {
    if (!jStr)
        return "";

    const jclass stringClass = env->GetObjectClass(jStr);
    const jmethodID getBytes = env->GetMethodID(stringClass, "getBytes", "(Ljava/lang/String;)[B");
    const jbyteArray stringJbytes = (jbyteArray) env->CallObjectMethod(jStr, getBytes,
                                                                       env->NewStringUTF("UTF-8"));

    size_t length = (size_t) env->GetArrayLength(stringJbytes);
    jbyte *pBytes = env->GetByteArrayElements(stringJbytes, NULL);

    string ret = string((char *) pBytes, length);
    env->ReleaseByteArrayElements(stringJbytes, pBytes, JNI_ABORT);

    env->DeleteLocalRef(stringJbytes);
    env->DeleteLocalRef(stringClass);
    return ret;
}

extern "C"
JNIEXPORT jstring JNICALL
Java_uz_orifjon_todoappmvc_fragments_MAinFragment_timePeriod(JNIEnv *env, jobject thiz,
                                                             jstring time1,
                                                             jstring time2) {

    string timeBefore = stringParse(env, time1);
    string timeAfter = stringParse(env, time2);

    string year1 = timeBefore.substr(0, 4);
    string year2 = timeAfter.substr(0, 4);
    string month1 = timeBefore.substr(4, 2);
    string month2 = timeAfter.substr(4, 2);


}


extern "C"
JNIEXPORT jstring JNICALL
Java_uz_orifjon_todoappmvc_adapters_RecyclerViewAdapter_timePerioad(JNIEnv *env, jobject thiz,
                                                                    jstring time1) {
    auto start = std::chrono::system_clock::now();
    auto end = std::chrono::system_clock::now();

    std::chrono::duration<double> elapsed_seconds = end - start;
    std::time_t end_time = std::chrono::system_clock::to_time_t(end);

    string timeNow = std::ctime(&end_time);

    string timeBefore = stringParse(env, time1);

    // Mon Oct  2 00:59:08 2017
    // 0 3 4 3

}