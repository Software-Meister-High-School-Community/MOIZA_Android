package com.domain.exception

import com.domain.exception.ExceptionMessage.NO_INTERNET_EXCEPTION_MESSAGE
import com.domain.exception.ExceptionMessage.UNKNOWN_EXCEPTION_MESSAGE
import java.lang.RuntimeException

object ExceptionMessage {
    const val NO_INTERNET_EXCEPTION_MESSAGE = "인터넷 연결을 확인해주세요."
    const val UNKNOWN_EXCEPTION_MESSAGE = "알 수 없는 에러가 발생했습니다."
}

class NoInternetException: RuntimeException() {
    override val message: String = NO_INTERNET_EXCEPTION_MESSAGE
}

class UnknownException: RuntimeException() {
    override val message: String = UNKNOWN_EXCEPTION_MESSAGE
}