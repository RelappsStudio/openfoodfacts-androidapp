package openfoodfacts.github.scrachx.openfood.utils;

import android.os.Parcel;
import android.os.Parcelable;

import openfoodfacts.github.scrachx.openfood.features.search.ProductSearchActivity;

/**
 * Class that contains search information
 */
public class SearchInfo implements Parcelable {
    private String mSearchQuery;
    private String mSearchTitle;
    private SearchType mSearchType;

    /**
     * Constructor for search information used by {@link ProductSearchActivity}
     *
     * @param mSearchQuery the search query
     * @param mSearchTitle title of the search
     * @param mSearchType type of search
     */
    public SearchInfo(String mSearchQuery, String mSearchTitle, SearchType mSearchType) {
        this.mSearchQuery = mSearchQuery;
        this.mSearchTitle = mSearchTitle;
        this.mSearchType = mSearchType;
    }

    /**
     * Constructor where search query is the same as search title
     *
     * @see #SearchInfo(String, String, SearchType)
     */
    public SearchInfo(String mSearchQuery, SearchType mSearchType) {
        this.mSearchQuery = mSearchQuery;
        this.mSearchTitle = mSearchQuery;
        this.mSearchType = mSearchType;
    }

    /**
     * @return search info for an incomplete product
     */
    public static SearchInfo emptySearchInfo() {
        return new SearchInfo("", "", SearchType.INCOMPLETE_PRODUCT);
    }

    public String getSearchQuery() {
        return mSearchQuery;
    }

    public String getSearchTitle() {
        return mSearchTitle;
    }

    protected SearchInfo(Parcel in) {
        this.mSearchQuery = in.readString();
        this.mSearchTitle = in.readString();
        this.mSearchType = (SearchType) in.readSerializable();
    }

    public void setSearchQuery(String mSearchQuery) {
        this.mSearchQuery = mSearchQuery;
    }

    public void setSearchTitle(String mSearchTitle) {
        this.mSearchTitle = mSearchTitle;
    }

    public SearchType getSearchType() {
        return mSearchType;
    }

    /**
     * Parcelable implementation
     */
    @Override
    public int describeContents() {
        return 0;
    }

    public void setSearchType(SearchType mSearchType) {
        this.mSearchType = mSearchType;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.mSearchQuery);
        dest.writeString(this.mSearchTitle);
        dest.writeSerializable(this.mSearchType);
    }

    public static final Creator<SearchInfo> CREATOR = new Creator<SearchInfo>() {
        @Override
        public SearchInfo createFromParcel(Parcel source) {
            return new SearchInfo(source);
        }

        @Override
        public SearchInfo[] newArray(int size) {
            return new SearchInfo[size];
        }
    };
}
